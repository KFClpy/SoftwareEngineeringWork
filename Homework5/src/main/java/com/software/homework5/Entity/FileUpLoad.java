package com.software.homework5.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FileUpLoad implements Serializable {
    private static final long serialVersionUID = 5736000341210865939L;
    private int id;
    private String filename;
    private String primaryname;
    private String extension;
    private String path;
    private String type;
    private long size;
    private String uploader;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPrimaryname() {
        return primaryname;
    }

    public void setPrimaryname(String primaryname) {
        this.primaryname = primaryname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }


    private String realname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileUpLoad that = (FileUpLoad) o;
        return id == that.id && size == that.size && filename.equals(that.filename) && primaryname.equals(that.primaryname) && extension.equals(that.extension) && path.equals(that.path) && type.equals(that.type) && uploader.equals(that.uploader) && createTime.equals(that.createTime) && realname.equals(that.realname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public FileUpLoad() {
    }

    public FileUpLoad( String filename, String primaryname, String extension, String path, String type, long size, String uploader, Date createTime, String realname) {
        this.filename = filename;
        this.primaryname = primaryname;
        this.extension = extension;
        this.path = path;
        this.type = type;
        this.size = size;
        this.uploader = uploader;
        this.createTime = createTime;
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "FileUpLoad{" +
                "filename='" + filename + '\'' +
                ", uploader='" + uploader + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}