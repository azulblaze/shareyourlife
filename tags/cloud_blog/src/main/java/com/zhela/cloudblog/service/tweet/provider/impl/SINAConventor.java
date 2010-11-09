package com.zhela.cloudblog.service.tweet.provider.impl;

import weibo4j.Comment;
import weibo4j.DirectMessage;
import weibo4j.RetweetDetails;
import weibo4j.Status;
import weibo4j.User;
import weibo4j.UserWapper;
import weibo4j.Count;

import com.zhela.cloudblog.rest.model.RESTAddress;
import com.zhela.cloudblog.rest.model.RESTCoordinate;
import com.zhela.cloudblog.rest.model.RESTImage;
import com.zhela.cloudblog.rest.model.RESTMessage;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTUser;
import com.zhela.cloudblog.rest.model.RESTComment;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTUserList;
import com.zhela.cloudblog.rest.model.RESTCount;

public class SINAConventor {
	
	public static RESTTweet StatusToREST(Status status){
		if(status==null){
			return null;
		}
		RESTTweet tweet = new RESTTweet();
		tweet.setContent(status.getText());
		tweet.setCreateDate(status.getCreatedAt());
		if(status.getBmiddle_pic()!=null){
			RESTImage image = new RESTImage();
			image.setMiddle(status.getBmiddle_pic());
			image.setOrignal(status.getOriginal_pic());
			image.setThumb(status.getThumbnail_pic());
			java.util.List<RESTImage> images = new java.util.ArrayList<RESTImage>();
			images.add(image);
			tweet.setImages(images);
		}
		tweet.setId(""+status.getId());
		tweet.setCreateUser(SINAConventor.UserToREST(status.getUser()));
		tweet.setSource(status.getSource());
		tweet.setCorrdinate(CoordinateToREST(status.getLatitude(),status.getLongitude()));
		Status retweet =  status.getRetweetDetails();
		if(retweet!=null){
			tweet.setForwardId(retweet.getId());
		}else{
			tweet.setForwardId(-1);
		}
		return tweet;
	}

	@SuppressWarnings("deprecation")
	public static RESTUser UserToREST(User user){
		if(user==null){
			return null;
		}
		RESTUser rest = new RESTUser();
		rest.setAccount(user.getName());
		rest.setId(user.getId()+"");
		rest.setBefriendsCount(user.getFollowersCount());
		rest.setStayAddress(AddressToRESTAddress(user));
		rest.setFriendsCount(user.getFriendsCount());
		rest.setHeader(ImageToREST(user.getProfileImageURL().toString(),null,null));
		rest.setName(user.getScreenName());
		rest.setTweetCount(user.getStatusesCount());
		rest.setCreateDate(user.getCreatedAt());
		rest.setLatestTweetId(user.getStatusId()+"");
		rest.setTweetDate(user.getStatusCreatedAt());
		rest.setDescription(user.getDescription());
		rest.setLatestTweet(user.getStatusText());
		if(user.getURL()!=null){
			rest.setWebSite(user.getURL().toString());
		}
		if(user.isFollowing()){
			rest.setRelation(RESTUser.RELATION_FOLLOW);
		}else{
			rest.setRelation(RESTUser.RELATION_NONE);
		}
		return rest;
	}
	
	public static RESTUserList UserToREST(UserWapper users){
		RESTUserList list = new RESTUserList();
		list.setNextCursor(users.getNextCursor());
		list.setPreviousCursor(users.getPreviousCursor());
		if(users!=null){
			java.util.List<RESTUser> _users = new java.util.ArrayList<RESTUser>();
			for(User _user:users.getUsers()){
				_users.add(UserToREST(_user));
			}
			list.setUsers(_users);
		}
		return list;
	}
	
	public static RESTAddress AddressToRESTAddress(User user){
		RESTAddress addr = new RESTAddress();
		addr.setAddress(user.getLocation());
		return addr;
	}
	
	public static RESTImage ImageToREST(String thumb,String middle,String orignal){
		RESTImage image = new RESTImage();
		if(thumb==null&&middle==null&&orignal==null){
			return null;
		}
		if(thumb!=null){
			image.setThumb(thumb);
		}else{
			if(middle!=null){
				image.setThumb(middle);
			}else{
				image.setThumb(orignal);
			}
		}
		if(middle!=null){
			image.setMiddle(middle);
		}else{
			image.setMiddle(image.getThumb());
		}
		if(orignal!=null){
			image.setOrignal(orignal);
		}else{
			image.setOrignal(image.getMiddle());
		}
		return image;
	}
	
	public static RESTCoordinate CoordinateToREST(double latitude,double longitude){
		RESTCoordinate rest = new RESTCoordinate();
		rest.setLatitude(latitude);
		rest.setLongitude(longitude);
		return rest;
	}
	
	public static RESTComment CommentToREST(Comment comment){
		if(comment!=null){
			RESTComment rest = new RESTComment();
			rest.setCreateDate(comment.getCreatedAt());
			rest.setId(comment.getId()+"");
			rest.setReplyUserName(comment.getInReplyToScreenName());
			rest.setReplyUserId(comment.getInReplyToUserId()+"");
			rest.setTweetId(comment.getInReplyToStatusId()+"");
			rest.setCoordinate(CoordinateToREST(comment.getLatitude(),comment.getLongitude()));
			rest.setSource(comment.getSource());
			rest.setContent(comment.getText());
			return rest;
		}
		return null;
	}
	
	public static RESTCommentList CommentListToREST(java.util.List<Comment> comments){
		if(comments!=null){
			RESTCommentList list = new RESTCommentList();
			java.util.List<RESTComment> tmp = new java.util.ArrayList<RESTComment>();
			for(Comment comment:comments){
				tmp.add(CommentToREST(comment));
			}
			list.setComments(tmp);
			return list;
		}
		return null;
	}
	
	public static RESTMessage MessageToREST(DirectMessage message){
		if(message!=null){
			RESTMessage rest = new RESTMessage();
			rest.setContent(message.getText());
			rest.setSender(UserToREST(message.getSender()));
			rest.setReceiver(UserToREST(message.getRecipient()));
			rest.setReplyId(message.getRecipientId());
			rest.setId(message.getId()+"");
			rest.setSendDate(message.getCreatedAt());
			return rest;
		}
		return null;
	}
	
	public static RESTCount CountToREST(Count count){
		if(count!=null){
			RESTCount _count = new RESTCount();
			_count.setComments(count.getComments());
			_count.setFollowers(count.getFollowers());
			_count.setMentions(count.getMentions());
			_count.setMessage(count.getDm());
			_count.setRetweet(count.getRt());
			return _count;
		}
		return null;
	}
}
