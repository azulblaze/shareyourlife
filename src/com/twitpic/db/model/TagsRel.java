package com.twitpic.db.model;

import java.util.Date;

public class TagsRel extends BaseModel{
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column tags_rel.id
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    private Long id;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column tags_rel.account
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    private String account;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column tags_rel.id_pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    private Long idPictures;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column tags_rel.id_tags
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    private Long idTags;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database column tags_rel.tag_time
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    private Date tagTime;

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column tags_rel.id
     *
     * @return the value of tags_rel.id
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column tags_rel.id
     *
     * @param id the value for tags_rel.id
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column tags_rel.account
     *
     * @return the value of tags_rel.account
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column tags_rel.account
     *
     * @param account the value for tags_rel.account
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column tags_rel.id_pictures
     *
     * @return the value of tags_rel.id_pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public Long getIdPictures() {
        return idPictures;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column tags_rel.id_pictures
     *
     * @param idPictures the value for tags_rel.id_pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public void setIdPictures(Long idPictures) {
        this.idPictures = idPictures;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column tags_rel.id_tags
     *
     * @return the value of tags_rel.id_tags
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public Long getIdTags() {
        return idTags;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column tags_rel.id_tags
     *
     * @param idTags the value for tags_rel.id_tags
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public void setIdTags(Long idTags) {
        this.idTags = idTags;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column tags_rel.tag_time
     *
     * @return the value of tags_rel.tag_time
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public Date getTagTime() {
        return tagTime;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column tags_rel.tag_time
     *
     * @param tagTime the value for tags_rel.tag_time
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    public void setTagTime(Date tagTime) {
        this.tagTime = tagTime;
    }
}