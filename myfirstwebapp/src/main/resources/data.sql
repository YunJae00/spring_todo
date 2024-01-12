-- data를 넣으려 하면 err (기본적으로 data.sql은 엔터티가 처리되기 전에 실행됨 -> property 에 적어줘야함)
-- spring.jpa.defer-datasource-initialization=true

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10001,'in28minutes', 'Get AWS Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10002,'in28minutes', 'Get Azure Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10003,'in28minutes', 'Get GCP Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10004,'in28minutes', 'Learn DevOps', CURRENT_DATE(), false);