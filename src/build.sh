#!/bin/bash


for file in `find ../ -name "*.jar"`
do
  THE_CLASSPATH=${THE_CLASSPATH}:${file}
done

for file in `find  $JBOSS_HOME/modules/system/layers/base -name "*.jar"`
do
  THE_CLASSPATH=${THE_CLASSPATH}:${file}
done

echo $THE_CLASSPATH

mkdir -p ../WebContent/WEB-INF/classes
cp -r * ../WebContent/WEB-INF/classes
find ../WebContent/WEB-INF/classes -name "*.java" -exec javac -cp ".:${THE_CLASSPATH}" {} \;
find ../WebContent/WEB-INF/classes -name "*.java" -exec rm -rf {} \;
find ../WebContent/WEB-INF/classes -name "*~" -exec rm -rf {} \;
find ../WebContent/WEB-INF/classes -name "deploy.sh" -exec rm -f {} \;
cd ../WebContent
jar cvf golivedocs.war 
rm -rf $JBOSS_HOME/standalone/deployments/*
cp golivedocs.war $JBOSS_HOME/standalone/deployments/


