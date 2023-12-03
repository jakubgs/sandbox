#!/usr/bin/env bash
#set -e

echo '---> SLEEP'
sleep 999 &
sleep 999 &

#echo '---> NESTED'
bash -c 'sleep 888 &' &

echo '---> LIST'
#pgrep -laP $$
ps --ppid $$

echo '---> PID'
echo $$

fg

cleanup() {
    echo '---> cleanup PID'
    echo $$

    echo '---> KILL'
    pkill -e -P $$ sleep

    echo '---> RESULT'
    echo $?
}

trap 'cleanup' SIGINT SIGTERM EXIT
sleep 30
