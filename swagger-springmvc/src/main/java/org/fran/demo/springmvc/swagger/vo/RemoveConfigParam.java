package org.fran.demo.springmvc.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="RemoveConfigParam",description="search body")
public class RemoveConfigParam {
    @ApiModelProperty("search type")
    private int removeType;
    @ApiModelProperty("search keywords")
    private String key;
    @ApiModelProperty("search version")
    private String version;
    @ApiModelProperty("os version")
    private String os;
    @ApiModelProperty("search channel")
    private String channel;

    public int getRemoveType() {
        return removeType;
    }

    public void setRemoveType(int removeType) {
        this.removeType = removeType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}