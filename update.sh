#!/bin/bash
echo -e "${1}"
url="http://39.104.105.27:8181/cloudapp/v2/applications/update?service=${1}"
HTTP_CODE=`curl -X GET -o /dev/null -s --head -w "%{http_code}" "${url}"`
if [ ${HTTP_CODE} -ne 200 ]
then
 echo -e "error-${HTTP_CODE}"
 exit 1
else 
 echo -e "success-${HTTP_CODE}"
 exit 0
fi
