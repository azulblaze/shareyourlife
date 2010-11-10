package test;

import weibo4j.Status;

import com.zhela.weibo.WeiboService;

public class Test {


	public static void main(String args[]) throws Exception {
		WeiboService ws = new WeiboService();
		ws.setOAuthAccessToken("fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7");
		System.out.println(ws.getUserInfo("1644395354").isFollowing());
		//System.out.println(ws.getUserInfo("1733230135","1644395354").isFollowing());
		//ws.createFriendship("1644395354", true);
		//ws.getHomeTimeline();
		//ws.getComments("3555167651", 1, 50);
		//ws.getFollowersStatuses(userId, position, size);
		//ws.getHomeTimeline();
		//Status status = ws.showStatus(3533445525l);
		//System.out.println(status);
		//System.out.println(status.getRetweetDetails());
	}
}
