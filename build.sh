#!/bin/bash
ORGANIZATION="com/codeborne"
MODULE="geoip"
VERSION=`grep version= build.gradle | sed "s/version='//g" | sed "s/'//g"`
TARGET=/var/www/repo/$ORGANIZATION/$MODULE/$MODULE-$VERSION.jar

./gradle clean test

if [[ "$S" == *SNAPSHOT ]]
then
  echo "Publish $TARGET (overwrite snapshot)"
  cp build/libs/$MODULE-$VERSION.jar $TARGET
elif [ -e $TARGET ]; then
  echo "Not publishing ($MODULE-$VERSION already exists)"
else
  echo "Publish $TARGET"
  cp build/libs/$MODULE-$VERSION.jar $TARGET
fi
