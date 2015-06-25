#!/bin/bash
ORGANIZATION="com/codeborne"
MODULE="geoip"
VERSION=`grep version= build.gradle | sed "s/version='//g" | sed "s/'//g"`
REPO=/var/www/repo/$ORGANIZATION/$MODULE
TARGET=$REPO/$MODULE-$VERSION.jar

./gradle clean test install

if [[ "$VERSION" == *SNAPSHOT ]]
then
  echo "Publish $TARGET (overwrite snapshot)"
  cp build/libs/$MODULE-$VERSION.jar $TARGET
elif [ -e $TARGET ]; then
  echo "Not publishing ($MODULE-$VERSION already exists)"
elif [ -e $REPO ]; then
  echo "Publish $TARGET"
  cp build/libs/$MODULE-$VERSION.jar $TARGET
  ./gradle -b deploy.gradle uploadArchives --info --stacktrace
else
  echo "Not publishing ($REPO does not exists)"
fi
