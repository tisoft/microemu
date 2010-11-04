#!/bin/sh
mvn clean package -DANDROID_SDK=/Users/markus/Downloads/android-sdk-mac_86/platforms/android-7
mkdir target/extracted
unzip target/microemu-iphone-3.0.0-SNAPSHOT.jar -d target/extracted
java -Xmx512M -jar ../../../../xmlvm/dist/xmlvm.jar --target=iphone --out=target --iphone-app=MicroEmu --in=target/extracted/ --resource=target/extracted/
#cd target
#make