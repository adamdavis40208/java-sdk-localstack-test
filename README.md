# java-sdk-localstack-test

I'm not a java dev, so apologies. 

There's a maven pom. It pulls in the aws sdk. I had some issues with 3rd party libs with this for awhile (like commons logging) but I hope it was all "my box" problems.

* Spin up localstack locally
`export SERVICES=s3:4572 && localstack start --docker`

* Create an s3 bucket named "mine"
  ( Doesn't seem to actually be needed, but hey let's do things right ) 
   > aws s3api create-bucket --bucket mine --endpoint-url http://localhost:4572

* Run this code
  > mvn exec:java -Dexec.mainClass="AWSActualTest"
