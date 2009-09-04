<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="div_panel">
	<div class="div_panel_header">
		&nbsp;信息发送
	</div>
	<div>
		<form method="post" action="msgsend.do">
		<input type="hidden" name="submit" value="submit" />
			<div class="div_panel">
				<table>
					<tr>
						<td>接收者:</td>
						<td>	
							<input name="msg_receiver" value="<s:property value='msg_receiver' />" />
							<input name="formMessages.receiver" type="hidden" value="<s:property value='msg_receiver_account' />" />
						</td>
					</tr>
					<tr>
						<td>信息标题:</td>
						<td><input name="formMessages.title" value="<s:property value='msg_title' />" /></td>
					</tr>
					<tr>
						<td colspan="2">信息内容:</td>
					</tr>	
					<tr>
						<td colspan="2">
							<textarea name="formMessages.msgContent"></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div>
				<input type="submit" value="发 送" />&nbsp;
				<input type="button" value="返 回" />
			</div>
		</form>
	</div>
</div>
