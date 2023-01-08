#!/usr/bin/env sh

echo -e '\033[92mChanging to the first available SDK MAN Java SDK 19 version.\033[0m'
echo -e '\033[91mRemember to run this command like this: . ./sdk19.sh\033[0m'
sdk install java 19-open
sdk use java $(sdk list java | grep -e installed -e "local only" | grep "| 19-open" |  cut -d'|' -f6- | cut -d' ' -f2-)
