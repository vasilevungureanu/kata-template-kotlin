#!/usr/bin/env bash
#
# Runs the static code analysis tools to validate Shell code.
# Runs the unit tests.

# If a command fails then do not proceed and fail this script too
set -o errexit
set -o pipefail

#######################################
# Find all shell scripts and check them
# Globals:
#  None
# Arguments:
#  None
# Returns:
#  None
#######################################
checkAllShellScripts() {
  # shellcheck disable=SC2044
  for file in $(find . -type f \( -name "*.sh" \)); do
    shellcheck "${file}"
  done
}

# Validate Shell code with shellcheck
checkAllShellScripts

# Validate Kotlin code with detekt and ktlint
./gradlew -q detekt ktlint ktlintFormat

# Runs the unit tests
./gradlew test
