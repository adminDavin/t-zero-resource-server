#!/usr/bin/env bash
# Author: davin.zhang

# shellcheck disable=SC2006,SC2164,SC2046
SHELL_FOLDER=$(cd `dirname "$0"`; pwd)
DOSM_UPGRADE_ACTIVITI_HOME=$(dirname "${SHELL_FOLDER}")
DOSM_UPGRADE_ACTIVITI_HOME_LOG="${DOSM_UPGRADE_ACTIVITI_HOME}/logs"

if [ ! -d "${DOSM_UPGRADE_ACTIVITI_HOME_LOG}" ]; then
    mkdir -p "${DOSM_UPGRADE_ACTIVITI_HOME_LOG}"
fi

LOGFILE="${DOSM_UPGRADE_ACTIVITI_HOME_LOG}/dosm-upgrade-activiti-data.log"

if [ ! -f "${LOGFILE}" ]; then
    touch "${LOGFILE}"
fi
log() {
    echo "$@" | tee -a "${LOGFILE}"
}

log_info() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') INFO: $1" | tee -a "${LOGFILE}"
}

log_error() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') ERROR: $1" | tee -a "${LOGFILE}"
}
