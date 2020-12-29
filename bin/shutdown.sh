#!/bin/sh

#==============================================================================

cd `dirname "$0"`/..
APPLICATION_HOME=`pwd`
cd $APPLICATION_HOME
if [ -z "$APPLICATION_HOME" ] ; then
    echo
    echo "Error: APPLICATION_HOME environment variable is not defined correctly."
    echo
    exit 1
fi
#==============================================================================

PID_FILE=$APPLICATION_HOME/stat/application.pid

if [ -e "$PID_FILE" ]; then
      kill -9 $(cat $PID_FILE)
      rm -f $PID_FILE
else
      echo "can not find pid file"
fi

rm -rf $APPLICATION_HOME/stat
echo "shutdown application and clean directory"