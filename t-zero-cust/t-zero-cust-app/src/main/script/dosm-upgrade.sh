#!/usr/bin/env bash
# Author: davin.zhang
# t-zero-undergroud-garage Startup script for t-zero-undergroud-garage
# processname: t-zero-undergroud-garage

# shellcheck disable=SC2006,SC2164,SC2046
SHELL_FOLDER=$(
    cd $(dirname "$0")
    pwd
)
SHELL_NAME=$(basename "$0")
T_ZERO_UNDERGROUND_GARAGE_HOME=$(dirname "${SHELL_FOLDER}")
ACTIONS=("upgrade")
ERROR_CODE=1
T_ZERO_OPTS="-DappName=t-zero-resource-manager"

# shellcheck disable=SC1090
source "${SHELL_FOLDER}/logger.sh"

usage() {
    echo "Usage: sh ${SHELL_NAME}"
}

check_params() {
    if [ -z "$1" ]; then
        echo "param invalid: -a examples: ${ACTIONS[*]}"
        exit ${ERROR_CODE}
    fi
    if [ -z "$2" ]; then
        echo "param invalid: -v examples: dev1.2"
        exit ${ERROR_CODE}
    fi
    if [ -n "$3" ]; then
        if [[ "$3" != "liquibase" ]]; then
            echo "param invalid: -v examples: liquibase"
            exit ${ERROR_CODE}
        fi
    fi

}

check_is_alive() {
    for ((i = 1; i <= 3; i++)); do
        sleep 1
        result=$(pgrep -f "${T_ZERO_OPTS}" >/dev/null)
        if [[ "$result" != "" ]]; then
            log_info "upgrading..."
            break
        fi
    done
    # shellcheck disable=SC2152
    return "no_process"
}

startup() {
    for application_jar in "${T_ZERO_UNDERGROUND_GARAGE_HOME}/lib"/*.jar; do
        CLASSPATH=${CLASSPATH}:${application_jar}
    done
    cd "${T_ZERO_UNDERGROUND_GARAGE_HOME}"
    JAVA_OPTS="-server -Xms128M -Xmx512M"
    JAVA_OPTS=" $JAVA_OPTS -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8 -Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}"
    JAVA_DEBUG_OPT=""
    CLASSPATH="${T_ZERO_UNDERGROUND_GARAGE_HOME}/conf:${CLASSPATH}"
    log_info "will upgrading current version to target version $1 $2"
    # shellcheck disable=SC2086
    nohup java $JAVA_OPTS $JAVA_DEBUG_OPT -classpath .:$CLASSPATH com.t.zero.cust.app.ResouceManagerApplication $1 $2 2>&1 &
    # shellcheck disable=SC2181
    if [[ $? -ne 0 ]]; then
        exit ${ERROR_CODE}
    fi
}

do_action() {
    case $1 in
    start)
        startup
        
        ;;
    \?)
        echo "param invalid: -a $1 is invalid aciton"
        usage
        exit ${ERROR_CODE}
        ;;
    esac
}

main() {
    # check_params "$@"
    do_action "$@"
}

main "start"