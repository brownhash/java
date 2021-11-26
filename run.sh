# help section
if [ "$1" == "help" ]
then
  printf "sh run.sh <package> <class>\nExample:\n\tsh run.sh com.basics Basics\n"
else
  # source code location
  PROJECT_LOCATION="./src/main/java"
  # package
  PACKAGE=$1
  # class name
  CLASS=$2
  # convert package structure to directory path
  PACKAGE_PATH=$(echo "$PACKAGE" | tr "." "/")
  if [ "$?" == "0" ]
  then
    CLASS_FILE_LOCATION="$PROJECT_LOCATION/$PACKAGE_PATH/$CLASS.java"
    # compile
    javac "$CLASS_FILE_LOCATION"
    if [ "$?" == "0" ]
    then
      # run
      cd $PROJECT_LOCATION && java "$PACKAGE.$CLASS"
    else
      printf "unable to compile %s" "$CLASS_FILE_LOCATION"
      exit $?
    fi
  else
    printf "unable to formulate package path from %s" "$PACKAGE"
    exit $?
  fi
fi
