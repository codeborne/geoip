#!/bin/bash
ORGANIZATION="com/codeborne"
MODULE="geoip"
VERSION=`grep version= build.gradle | sed "s/version='//g" | sed "s/'//g"`
TARGET=/var/www/repo/$ORGANIZATION/$MODULE/$MODULE-$VERSION.jar

./gradle clean install

if [[ "$S" == *SNAPSHOT ]]
then
  echo "Not publishing (SNAPSHOT version)"
elif [ -e $TARGET ]; then
  echo "Not publishing ($MODULE-$VERSION already exists)"
else
  cp build/libs/$MODULE-$VERSION.jar $TARGET
fi
