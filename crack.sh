mvn clean compile
if [[ "$?" == "0" ]]; then
  cd target/classes
  jar uvf ../../lib/x-pack-core-7.14.0.jar org/elasticsearch/license/LicenseVerifier.class org/elasticsearch/xpack/core/XPackBuild.class
  echo "pack sucess, file is: ../../lib/x-pack-core-7.14.0.jar"
else
  echo "pack fail"
fi
