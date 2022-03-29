package com.t.zero.res.c.manager.co.file;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import io.minio.CreateMultipartUploadResponse;
import io.minio.ListPartsResponse;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadPartResponse;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.messages.Part;

/**
 * @author davinzhang
 * 
 * @date 2022/02/10
 * 
 * @desc 分片 断点续传功能实现
 */

public class CustomMinioClient extends MinioClient {

    protected CustomMinioClient(MinioClient client) {
        super(client);
    }

    @Override
    public CreateMultipartUploadResponse createMultipartUpload(
        String bucket,
        String region,
        String object,
        Multimap<String, String> headers,
        Multimap<String, String> extraQueryParams) throws InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException, IOException {
        return super.createMultipartUpload(bucket, region, object, headers, extraQueryParams);
    }

    public CreateMultipartUploadResponse createMultipartUpload(
        String bucket,
        String object,
        String contentType) throws InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException, IOException {
        HashMultimap<String, String> headers = HashMultimap.create();
        headers.put("Content-Type", contentType);
        return createMultipartUpload(bucket, null, object, headers, null);
    }

    @Override
    public UploadPartResponse uploadPart(
        String bucketName,
        String region,
        String objectName,
        Object data,
        int length,
        String uploadId,
        int partNumber,
        Multimap<String, String> extraHeaders,
        Multimap<String, String> extraQueryParams) throws NoSuchAlgorithmException, InsufficientDataException, IOException, InvalidKeyException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException {
        return super.uploadPart(bucketName, region, objectName, data, length, uploadId, partNumber, extraHeaders, extraQueryParams);
    }

    public UploadPartResponse uploadPart(
        String bucketName,
        String objectName,
        Object data,
        int length,
        String uploadId,
        int partNumber) throws NoSuchAlgorithmException, InsufficientDataException, IOException, InvalidKeyException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException {
        return super.uploadPart(bucketName, null, objectName, data, length, uploadId, partNumber, null, null);
    }

    @Override
    public ObjectWriteResponse completeMultipartUpload(
        String bucketName,
        String region,
        String objectName,
        String uploadId,
        Part[] parts,
        Multimap<String, String> extraHeaders,
        Multimap<String, String> extraQueryParams) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, ServerException, InternalException, XmlParserException, InvalidResponseException, ErrorResponseException {
        return super.completeMultipartUpload(bucketName, region, objectName, uploadId, parts, extraHeaders, extraQueryParams);
    }

    public ObjectWriteResponse completeMultipartUpload(
        String bucketName,
        String objectName,
        String uploadId) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, ServerException, InternalException, XmlParserException, InvalidResponseException, ErrorResponseException {
        Part[] parts = new Part[1000];
        ListPartsResponse partResult = this.listParts(bucketName, objectName, 1000, 0, uploadId);
        int partNumber = 1;
        for (Part part : partResult.result().partList()) {
            parts[partNumber - 1] = new Part(partNumber, part.etag());
            partNumber++;
        }
        return completeMultipartUpload(bucketName, null, objectName, uploadId, parts, null, null);
    }

    @Override
    public ListPartsResponse listParts(
        String bucketName,
        String region,
        String objectName,
        Integer maxParts,
        Integer partNumberMarker,
        String uploadId,
        Multimap<String, String> extraHeaders,
        Multimap<String, String> extraQueryParams) throws NoSuchAlgorithmException, InsufficientDataException, IOException, InvalidKeyException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException {
        return super.listParts(bucketName, region, objectName, maxParts, partNumberMarker, uploadId, extraHeaders, extraQueryParams);
    }

    public ListPartsResponse listParts(
        String bucketName,
        String objectName,
        Integer maxParts,
        Integer partNumberMarker,
        String uploadId) throws NoSuchAlgorithmException, InsufficientDataException, IOException, InvalidKeyException, ServerException, XmlParserException, ErrorResponseException, InternalException, InvalidResponseException {
        return listParts(bucketName, null, objectName, maxParts, partNumberMarker, uploadId, null, null);
    }

}
