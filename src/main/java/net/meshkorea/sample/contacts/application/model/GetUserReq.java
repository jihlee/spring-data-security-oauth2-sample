package net.meshkorea.sample.contacts.application.model;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
public class GetUserReq {
    private Long id;

    public GetUserReq(Long id) {
        this.id = id;
    }

    private GetUserReq() {

    }

    public Long getId() {
        return id;
    }
}
