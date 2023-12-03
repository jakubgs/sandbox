#!/usr/bin/env bash
set -e
PROCS_TO_KILL=("xcape" "xclip" "nvim")

ps faux | grep $PROCS_TO_KILL
