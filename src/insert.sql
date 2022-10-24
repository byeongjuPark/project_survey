ALTER TABLE `semi_project`.`result` 
ADD PRIMARY KEY (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`);
;

INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('1', '현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('2', 'OTT에서 추천해주는 컨텐츠는 만족하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('3', '업로드 주기는 적당하다고 생각하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('4', '현재 OTT에서 제공하고 있는 자막 제공 서비스에 만족 하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('5', '이용중인 구독료는 적당하다고 생각하는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('6', '향후 구독을 계속 유지할 생각이 있는가');
INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('7', '지인에게 해당 서비스를 추천할 의향이 있는가');

INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('1', '박병주');
INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('2', '윤선아');
INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('3', '박찬희');

INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('1', '전혀 아니다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('2', '아니다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('3', '보통이다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('4', '그렇다');
INSERT INTO `semi_project`.`answers` (`ANSWER_UID`, `ANSWER`) VALUES ('5', '매우 그렇다');

INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '1', '1');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '3', '2');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '4', '3');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '5', '4');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '2', '5');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('1', '3', '6');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '4', '7');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '3', '1');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '5', '2');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '1', '3');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '3', '4');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '5', '5');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '2', '6');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('2', '3', '7');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '1', '1');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '2', '2');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '3', '3');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '5', '4');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '5', '5');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '3', '6');
INSERT INTO `semi_project`.`result` (`PARTICIPANTS_UID`, `ANSWER_UID`, `QUESTIONS_UID`) VALUES ('3', '2', '7');

