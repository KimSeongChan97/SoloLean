package imageboard.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class NCPObjectStorageService {
    private String accessKey = "ncp_iam_BPASKR1rkHdM4GZvZUXw";
    private String secretKey = "ncp_iam_BPKSKRCJwDshvcUw4ZcyZ35rLxtxCmmYEY";
    private String regionName = "kr-standard";
    private String endPoint = "https://kr.object.ncloudstorage.com";
    private String bucketName = "bitcamp-9th-bucket-65";

    private final AmazonS3 s3;

    public NCPObjectStorageService() {
        s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }

    public String uploadFile(File file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.length());
        metadata.setContentType(Files.probeContentType(file.toPath()));

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "storage/" + fileName, new FileInputStream(file), metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead);

        s3.putObject(putObjectRequest);
        return "https://kr.object.ncloudstorage.com/" + bucketName + "/storage/" + fileName;
    }

    public void deleteFile(String fileName) {
        s3.deleteObject(bucketName, "storage/" + fileName);
    }
}