#!/bin/sh
source ./env.sh

noJavaHome=false
if [ -z "$JAVA_HOME" ] ; then
    noJavaHome=true
fi
if [ ! -e "$JAVA_HOME/bin/java" ] ; then
    noJavaHome=true
fi
if $noJavaHome ; then
    echo
    echo "Error: JAVA_HOME environment variable is not set."
    echo
    exit 1
fi
#==============================================================================

cd `dirname "$0"`/..
export APPLICATION_HOME=`pwd`
cd $APPLICATION_HOME
if [ -z "$APPLICATION_HOME" ] ; then
    echo
    echo "Error: APPLICATION_HOME environment variable is not defined correctly."
    echo
    exit 1
fi
#==============================================================================

STAT_DIR=$APPLICATION_HOME/stat
if [ ! -d "$STAT_DIR" ]; then
        echo "create stat dir"
        mkdir $STAT_DIR
else
        echo "stat dir exist"
fi
#==============================================================================

if [ -z "$Xmx" ] ; then
    Xmx=4G
fi

if [ -z "$Xms" ] ; then
    Xms=4G
fi

if [ -z "$PermSize" ] ; then
    PermSize=256M
fi

if [ -z "$MaxPermSize" ] ; then
    MaxPermSize=256M
fi


export JAVA_OPTS="-server -Xmx$Xmx -Xms$Xms -XX:NewRatio=3 -XX:SurvivorRatio=4 -Xss256k -XX:PermSize=$PermSize -XX:MaxPermSize=$MaxPermSize -XX:MaxTenuringThreshold=15 -XX:+AggressiveOpts -XX:+UseBiasedLocking -XX:+UseFastAccessorMethods -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:CMSFullGCsBeforeCompaction=1 -XX:+UseCMSCompactAtFullCollection -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=75 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=8 -XX:GCLogFileSize=128M -Xloggc:$APPLICATION_HOME/stat/gc.bin -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$APPLICATION_HOME/stat -XX:OnOutOfMemoryError='$APPLICATION_HOME/bin/shutdown.sh -force' -XX:OnError='$APPLICATION_HOME/bin/shutdown.sh -force' -XX:ErrorFile=$APPLICATION_HOME/stat/hs_err_pid%p.log -Djava.awt.headless=true -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=34031"


#startup Server
RUN_CMD="nohup \"$JAVA_HOME/bin/java\""
RUN_CMD="$RUN_CMD $JAVA_OPTS"
RUN_CMD="$RUN_CMD -jar ./comment-1.0.0.jar"
RUN_CMD="$RUN_CMD >> \"$APPLICATION_HOME/stat/console.log\" 2>&1 &"
echo $RUN_CMD
eval $RUN_CMD

echo $! > $APPLICATION_HOME/stat/application.pid
echo "Application started."
