package com.zhela.cloudblog.service.ourservice.impl;

import java.util.Date;

import com.zhela.cloudblog.dao.ourservice.AnswerDAO;
import com.zhela.cloudblog.dao.ourservice.OtherAnswerDAO;
import com.zhela.cloudblog.dao.ourservice.QuestionDAO;
import com.zhela.cloudblog.dao.ourservice.SurveyDAO;
import com.zhela.cloudblog.model.ourservice.Answer;
import com.zhela.cloudblog.model.ourservice.OtherAnswer;
import com.zhela.cloudblog.model.ourservice.Question;
import com.zhela.cloudblog.model.ourservice.Survey;
import com.zhela.cloudblog.service.ourservice.SurveyService;

public class SurveyServiceImpl implements SurveyService {

	private SurveyDAO surveyDAO;
	private QuestionDAO questionDAO;
	private OtherAnswerDAO otherAnswerDAO;
	private AnswerDAO answerDAO;
	public void setSurveyDAO(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	public void setOtherAnswerDAO(OtherAnswerDAO otherAnswerDAO) {
		this.otherAnswerDAO = otherAnswerDAO;
	}

	public void setAnswerDAO(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}

	
	
	
	@Override
	public Answer createAnswer(Answer answer,String account) throws Exception {
		long id = answer.getQuestionId();
		Question question = questionDAO.selectByPrimaryKey(id);
		if(question!=null){
			id = question.getSurveyId();
			Survey survey = surveyDAO.selectByPrimaryKey(id);
			if(survey!=null){
				if(survey.getAccount().equals(account)){
					answerDAO.insert(answer);
					return answer;
				}
			}
		}
		throw new Exception("创建失败，你没有权限");
	}

	@Override
	public Question createQuestion(Question question,String account) throws Exception {
		long id = question.getSurveyId();
		Survey survey = surveyDAO.selectByPrimaryKey(id);
		if(survey!=null){
			if(survey.getAccount().equals(account)){
				questionDAO.insert(question);
				return question;
			}
		}
		throw new Exception("创建失败，你没有权限");
	}

	@Override
	public Survey createSurvey(Survey survey) throws Exception {
		surveyDAO.insert(survey);
		return survey;
	}

	@Override
	public int deleteAnswer(long id, String account) throws Exception {
		Answer answer = answerDAO.selectByPrimaryKey(id);
		if(answer==null){
			return 0;
		}
		id = answer.getQuestionId();
		Question question = questionDAO.selectByPrimaryKey(id);
		if(question!=null){
			id = question.getSurveyId();
			Survey survey = surveyDAO.selectByPrimaryKey(id);
			if(survey!=null){
				if(survey.getAccount().equals(account)){
					answerDAO.deleteByPrimaryKey(answer.getId());
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	public int deleteQuestion(long id, String account) throws Exception {
		Question question = questionDAO.selectByPrimaryKey(id);
		if(question==null){
			return 0;
		}
		id = question.getSurveyId();
		Survey survey = surveyDAO.selectByPrimaryKey(id);
		if(survey!=null){
			if(survey.getAccount().equals(account)){
				answerDAO.deleteByPrimaryKey(question.getId());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int deleteSurvey(long id, String account) throws Exception {
		Survey survey = surveyDAO.selectByPrimaryKey(id);
		if(survey==null){
			return 0;
		}
		if(survey.getAccount().equals(account)){
			surveyDAO.deleteByPrimaryKey(survey.getId());
			return 1;
		}
		return 0;
	}

	@Override
	public Answer updateAnswer(long id,String type,String title,Integer select_time,Integer sort_order, String content, String account)
			throws Exception {
		Answer answer = answerDAO.selectByPrimaryKey(id);
		if(answer==null){
			throw new Exception("你所更新的内容不存在");
		}
		Question question = questionDAO.selectByPrimaryKey(answer.getQuestionId());
		if(question!=null){
			id = question.getSurveyId();
			Survey survey = surveyDAO.selectByPrimaryKey(id);
			if(survey!=null){
				if(account==null){
					if(survey.getStatus().equals(Survey.STATUS_OVERDUE)){
						throw new Exception("该调查已经过期");
					}
					if(survey.getStatus().equals(Survey.STATUS_STOP)){
						throw new Exception("该调查已经结束");
					}
					if(survey.getStatus().equals(Survey.STATUS_PROCESS)){
						if(survey.getEndTime().getTime()<new Date().getTime()){
							survey.setStatus(Survey.STATUS_OVERDUE);
							surveyDAO.updateByPrimaryKey(survey);
							throw new Exception("该调查已经过期");
						}else{
							if(answer.getType().equals(Answer.TYPE_INPUT)){
								OtherAnswer record = new OtherAnswer();
								record.setAnswerId(answer.getId());
								record.setContent(content);
								otherAnswerDAO.insert(record);
								answer.setSelectTime(answer.getSelectTime()+1);
							}else{
								answer.setSelectTime(answer.getSelectTime()+1);
							}
							return answer;
						}
					}
					throw new Exception("该调查不存在");
				}
				if(survey.getAccount().equals(account)){
					if(type!=null){
						answer.setType(type);
					}
					if(title!=null){
						answer.setTitle(title);
					}
					if(select_time!=null){
						answer.setSelectTime(select_time);
					}
					if(sort_order!=null){
						answer.setSortOrder(sort_order);
					}
					answerDAO.updateByPrimaryKeyWithBLOBs(answer);
					return answer;
				}
			}
		}
		throw new Exception("更新失败，你没有权限");
	}

	@Override
	public Question updateQuestion(long id,String type,String title,Integer sort_order, String account)
			throws Exception {
		Question question = questionDAO.selectByPrimaryKey(id);
		if(question==null){
			throw new Exception("你所更新的内容不存在");
		}
		if(question!=null){
			id = question.getSurveyId();
			Survey survey = surveyDAO.selectByPrimaryKey(id);
			if(survey!=null){
				if(survey.getAccount().equals(account)){
					if(type!=null){
						question.setType(type);
					}
					if(title!=null){
						question.setTitle(title);
					}
					if(sort_order!=null){
						question.setSortOrder(sort_order);
					}
					questionDAO.updateByPrimaryKeyWithBLOBs(question);
					return question;
				}
			}
		}
		throw new Exception("更新失败，你没有权限");
	}

	@Override
	public Survey updateSurvey(Survey survey) throws Exception {
		Survey tmp = surveyDAO.selectByPrimaryKey(survey.getId());
		if(tmp!=null&&tmp.getAccount().equals(survey.getAccount())){
			surveyDAO.updateByPrimaryKey(survey);
		}
		throw new Exception("你所更新的内容不存在");
	}
	
}
