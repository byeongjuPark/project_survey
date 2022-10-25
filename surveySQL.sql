INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('1', '현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('2', 'OTT에서 추천해주는 컨텐츠는 만족하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('3', '업로드 주기는 적당하다고 생각하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('4', '현재 OTT에서 제공하고 있는 자막 제공 서비스에 만족 하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('5', '이용중인 구독료는 적당하다고 생각하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('6', '향후 구독을 계속 유지할 생각이 있는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('7', '지인에게 해당 서비스를 추천할 의향이 있는가');


INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('1', '전혀 아니다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('2', '아니다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('3', '보통이다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('4', '그렇다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('5', '매우 그렇다');

INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '1');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '1');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '1');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '1');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '1');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '2');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '2');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '2');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '2');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '2');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '3');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '3');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '3');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '3');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '3');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '4');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '4');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '4');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '4');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '4');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '5');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '5');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '5');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '5');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '5');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '6');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '6');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '6');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '6');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '6');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '7');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '7');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '7');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('4', '7');
INSERT INTO `semi_project`.`questions_answers` (`ANSWER_UID`, `QUESTIONS_UID`) VALUES ('5', '7');


-- 회원 가입
INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('1', '박병주');
-- 답안 출력
SELECT answer FROM (questions
INNER JOIN questions_answers ON questions_answers.QUESTIONS_UID = questions.QUESTIONS_UID)
INNER JOIN answers ON questions_answers.ANSWER_UID = answers.ANSWER_UID
WHERE questions.QUESTIONS_UID = '1';
-- 사용자 답 입력
INSERT INTO result (PARTICIPANTS_UID, ANSWER_UID, QUESTIONS_UID) VALUES ('1', '1', '1'),
('1', '3', '2'),
('1', '3', '3'),
('1', '4', '4'),
('1', '5', '5'),
('1', '2', '6'),
('1', '4', '7');
-- 설문자별 답항 통계
SELECT * FROM result 
INNER JOIN participants ON result.PARTICIPANTS_UID = participants.PARTICIPANTS_UID 
INNER JOIN answers ON result.ANSWER_UID = answers.ANSWER_UID
ORDER BY NAME, QUESTIONS_UID;

SELECT * FROM rquestions_answersesult;

SELECT count(ANSWER_UID), QUESTIONS_UID FROM result
group by QUESTIONS_UID;


SELECT ANSWER_UID FROM questions_answers WHERE = ? ORDER BY QUESTIONS_UID;

SELECT ANSWER_UID FROM questions_answers WHERE PARTICIPANTS_UID = '1' ORDER BY QUESTIONS_UID;
SELECT * FROM result;

SELECT ANSWER_UID FROM RESULT WHERE PARTICIPANTS_UID = ? ORDER BY QUESTIONS_UID;
