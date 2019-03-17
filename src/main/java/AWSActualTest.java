import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.client.builder.AwsClientBuilder;

import java.io.ByteArrayInputStream;

public class AWSActualTest {
    private static BasicAWSCredentialsProvider awsCredentials = new BasicAWSCredentialsProvider(new BasicAWSCredentials("", ""));
    private static AmazonS3 s3Client = AmazonS3ClientBuilder.standard().
            withEndpointConfiguration(getEndpointConfigurationS3()).withCredentials(awsCredentials).build();

    protected static AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(String endpointURL) {
        return new AwsClientBuilder.EndpointConfiguration(endpointURL, "us-east-1");
    }

    protected static AwsClientBuilder.EndpointConfiguration getEndpointConfigurationSQS() {
        return getEndpointConfiguration("http://localhost:4576");
    }

    protected static AwsClientBuilder.EndpointConfiguration getEndpointConfigurationS3() {
        return getEndpointConfiguration("http://localhost:4572");
    }

    public static void main(String[] args){
        try {
            String putString = "HELLLOOOOO0000";
            PutObjectRequest putObjectRequest = (PutObjectRequest) fromString();
            putObjectRequest = putObjectRequest.withInputStream(new ByteArrayInputStream(putString.getBytes("UTF-8")));
            s3Client.putObject(putObjectRequest);
        }catch(Exception e){
            System.err.println("Stuff blew up " + e);
        }
    }

    private static Object fromString(){
        String s = "rO0ABXNyADBjb20uYW1hem9uYXdzLnNlcnZpY2VzLnMzLm1vZGVsLlB1dE9iamVjdFJlcXVlc3QFF+GblPYAzAIAAVoAD2lzUmVxdWVzdGVyUGF5c3hyADhjb20uYW1hem9uYXdzLnNlcnZpY2VzLnMzLm1vZGVsLkFic3RyYWN0UHV0T2JqZWN0UmVxdWVzdHZMFNfoHf/WAgAOTAARYWNjZXNzQ29udHJvbExpc3R0ADNMY29tL2FtYXpvbmF3cy9zZXJ2aWNlcy9zMy9tb2RlbC9BY2Nlc3NDb250cm9sTGlzdDtMAApidWNrZXROYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7TAAJY2FubmVkQWNsdAA5TGNvbS9hbWF6b25hd3Mvc2VydmljZXMvczMvbW9kZWwvQ2FubmVkQWNjZXNzQ29udHJvbExpc3Q7TAAEZmlsZXQADkxqYXZhL2lvL0ZpbGU7TAADa2V5cQB+AANMAAhtZXRhZGF0YXQAMExjb20vYW1hem9uYXdzL3NlcnZpY2VzL3MzL21vZGVsL09iamVjdE1ldGFkYXRhO0wAGW9iamVjdExvY2tMZWdhbEhvbGRTdGF0dXNxAH4AA0wADm9iamVjdExvY2tNb2RlcQB+AANMABlvYmplY3RMb2NrUmV0YWluVW50aWxEYXRldAAQTGphdmEvdXRpbC9EYXRlO0wAEHJlZGlyZWN0TG9jYXRpb25xAH4AA0wAGXNzZUF3c0tleU1hbmFnZW1lbnRQYXJhbXN0ADtMY29tL2FtYXpvbmF3cy9zZXJ2aWNlcy9zMy9tb2RlbC9TU0VBd3NLZXlNYW5hZ2VtZW50UGFyYW1zO0wADnNzZUN1c3RvbWVyS2V5dAAwTGNvbS9hbWF6b25hd3Mvc2VydmljZXMvczMvbW9kZWwvU1NFQ3VzdG9tZXJLZXk7TAAMc3RvcmFnZUNsYXNzcQB+AANMAAd0YWdnaW5ndAAvTGNvbS9hbWF6b25hd3Mvc2VydmljZXMvczMvbW9kZWwvT2JqZWN0VGFnZ2luZzt4cHB0AARtaW5lcHB0ACQxNWVkYmQ0OC05ZDliLTRlODMtOWI4OC0zNmZiYWE5MTRhYjRzcgAuY29tLmFtYXpvbmF3cy5zZXJ2aWNlcy5zMy5tb2RlbC5PYmplY3RNZXRhZGF0YW58m0LtULTnAgAHTAAOZXhwaXJhdGlvblRpbWVxAH4AB0wAFGV4cGlyYXRpb25UaW1lUnVsZUlkcQB+AANMAA9odHRwRXhwaXJlc0RhdGVxAH4AB0wACG1ldGFkYXRhdAAPTGphdmEvdXRpbC9NYXA7TAAOb25nb2luZ1Jlc3RvcmV0ABNMamF2YS9sYW5nL0Jvb2xlYW47TAAVcmVzdG9yZUV4cGlyYXRpb25UaW1lcQB+AAdMAAx1c2VyTWV0YWRhdGFxAH4AD3hwcHBwc3IAEWphdmEudXRpbC5UcmVlTWFwDMH2Pi0lauYDAAFMAApjb21wYXJhdG9ydAAWTGphdmEvdXRpbC9Db21wYXJhdG9yO3hwc3IAKmphdmEubGFuZy5TdHJpbmckQ2FzZUluc2Vuc2l0aXZlQ29tcGFyYXRvcncDXH1cUOXOAgAAeHB3BAAAAAJ0AA5Db250ZW50LUxlbmd0aHNyAA5qYXZhLmxhbmcuTG9uZzuL5JDMjyPfAgABSgAFdmFsdWV4cgAQamF2YS5sYW5nLk51bWJlcoaslR0LlOCLAgAAeHAAAAAAAAAADnQAHHgtYW16LXNlcnZlci1zaWRlLWVuY3J5cHRpb250AAZBRVMyNTZ4cHBzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAAAXQAFXVzZXItbWV0YWRhdGEtZW5jb2RlZHQABHRydWV4cHBwcHBwcHAA";
        byte [] data = java.util.Base64.getDecoder().decode( s );
        Object o = new Object();
        try {
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(
                    new java.io.ByteArrayInputStream(data));
            o = ois.readObject();
            ois.close();
            return o;
        }catch(Exception e){
            System.out.println("Well, stuff blew up");
        }
        return o;
    }

    private static class BasicAWSCredentialsProvider implements AWSCredentialsProvider {
        private final AWSCredentials awsCredentials;

        BasicAWSCredentialsProvider(AWSCredentials awsCredentials) {
            this.awsCredentials = awsCredentials;
        }

        @Override
        public AWSCredentials getCredentials() {
            return awsCredentials;
        }

        @Override
        public void refresh() {

        }
    }
}
