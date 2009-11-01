#!/bin/sh
mvn clean package -DANDROID_SDK=/Applications/Development/Android/android-sdk-mac_x86-1.6_r1/platforms/android-1.5
mkdir target/extracted
unzip target/microemu-iphone-3.0.0-SNAPSHOT.jar -d target/extracted
java -jar ../../../../xmlvm/dist/xmlvm.jar --target=iphone --out=target --iphone-app=MicroEmu --in=target/extracted/
#cd target
#make