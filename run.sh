# source code location
PROJECT_LOCATION="src/main/java"

# help section
if [[ "$1" == "help" || "$1" == "" ]]
then
  printf "sh run.sh <package> <class>\nExample:\n\tsh run.sh com.basics Basics\n"
else
  # package
  PACKAGE=$1
  # convert package structure to directory path
  PACKAGE_PATH=$(echo "$PACKAGE" | tr "." "/")
  if [ "$?" == "0" ]
  then
    rm -rf $PROJECT_LOCATION/$PACKAGE_PATH/*.class
    # exit 0 if clean is given as parameter
    if [ "$2" == "clean" ]
    then
      exit 0
    fi
    # compile
    javac $PROJECT_LOCATION/$PACKAGE_PATH/*.java

    # class name
    CLASS=$2
    cd $PROJECT_LOCATION && java "$PACKAGE.$CLASS"
  else
    printf "unable to formulate package path from %s" "$PACKAGE"
    exit $?
  fi
fi
