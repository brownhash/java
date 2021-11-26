# help section
if [[ "$1" == "help" || "$1" == "" ]]
then
  printf "sh run.sh <package> <class>\nExample:\n\tsh run.sh com.basics Basics\n"
else
  # source code location
  PROJECT_LOCATION="src/main/java"
  # package
  PACKAGE=$1
  # class name
  CLASS=$2
  # convert package structure to directory path
  PACKAGE_PATH=$(echo "$PACKAGE" | tr "." "/")
  if [ "$?" == "0" ]
  then
    # compile
    javac $PROJECT_LOCATION/$PACKAGE_PATH/*.java
    cd $PROJECT_LOCATION && java "$PACKAGE.$CLASS"
  else
    printf "unable to formulate package path from %s" "$PACKAGE"
    exit $?
  fi
fi
