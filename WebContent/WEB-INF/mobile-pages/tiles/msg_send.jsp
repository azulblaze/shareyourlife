<%@ page language="java" contentType="application/xhtml+xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="div_panel">
	<div><hr /></div>
	<div>
		<span>信息发送</span>
	</div>
	<div>
		<form method="post" action="msgsend.do">
		<input type="hidden" name="submit" value="submit" />
			<table width="100%">
				<tr>
					<td>接收者:</td>
					<td>	
						<input value="<s:property value='msg_receiver' />" />
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
				<tr>
					<td colspan="2"><hr /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="发 送" />&nbsp;
						<input type="button" value="返 回" />
					</td>			
				</tr>
			</table>
		</form>
	</div>
	<div><hr /></div>
</div>
