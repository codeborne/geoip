#!/bin/bash
ORGANIZATION="com/codeborne"
MODULE="geoip"
VERSION=`grep version= build.gradle | sed "s/version='//g" | sed "s/'//g"`
REPO=/var/www/repo/$ORGANIZATION/$MODULE
TARGET=$REPO/$MODULE-$VERSION.jar

./gradle clean test install

echo ""
echo ""
echo ""

if [[ "$VERSION" == *SNAPSHOT ]]
then
  echo "Skip publishing $TARGET (nobody needs snapshot)"
elif [ -e $TARGET ]; then
  echo "Not publishing ($MODULE-$VERSION already exists)"
elif [ -e $REPO ]; then

  echo ""
  echo ""
  echo ""
  echo " ********************************************************* "
  cp build/libs/$MODULE-$VERSION.jar $TARGET
  echo "Published $TARGET"
  echo " ********************************************************* "
  echo ""
  echo ""
  echo ""

  ./gradle -b deploy.gradle uploadArchives --info --stacktrace
else
  echo "Not publishing ($REPO does not exists)"
fi
