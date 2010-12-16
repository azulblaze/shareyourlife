package com.zhela.cloudblog.service.ourservice;

import com.zhela.cloudblog.model.ourservice.Answer;
import com.zhela.cloudblog.model.ourservice.Question;
import com.zhela.cloudblog.model.ourservice.Survey;

public interface SurveyService {

	public Survey createSurvey(Survey survey) throws Exception;
	
	public Survey updateSurvey(Survey survey) throws Exception;
	
	public int deleteSurvey(long id,String account) throws Exception;
	
	public Question createQuestion(Question question,String account) throws Exception;
	
	public Question updateQuestion(long id,String type,String title,Integer sort_order,String account) throws Exception;
	
	public int deleteQuestion(long id,String account) throws Exception;
	
	public Answer createAnswer(Answer answer,String account) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @param title
	 * @param select_time
	 * @param sort_order
	 * @param content 
	 * @param account if account is null, means answer question
	 * @return
	 * @throws Exception
	 */
	public Answer updateAnswer(long id,String type,String title,Integer select_time,Integer sort_order,String content,String account) throws Exception;
	
	public int deleteAnswer(long id,String account) throws Exception;
	
	
}
