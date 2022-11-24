-- Criação do schema do projeto
CREATE SCHEMA `projectstrangered`;

-- Excluir schema criado 
DROP DATABASE `projectstrangered`;

-- Selecionar o schema criado
use projectstrangered;

-- Mostrando todos os registros nas tabelas
SELECT * FROM comment;
SELECT * FROM post;
SELECT * FROM refresh_token;
SELECT * FROM subreddit;
SELECT * FROM subreddit_posts;
SELECT * FROM token;
SELECT * FROM user;
SELECT * FROM vote;

-- Deletando os registros na tabelas
DELETE FROM comment;
DELETE FROM post;
DELETE FROM refresh_token; 
DELETE FROM subreddit;
DELETE FROM subreddit_posts;
DELETE FROM token;
DELETE FROM user;
DELETE FROM vote;

-- Deletar as tabelas criadas automaticamente pela aplicação
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post; 
DROP TABLE IF EXISTS refresh_token;
DROP TABLE IF EXISTS subreddit;
DROP TABLE IF EXISTS subreddit_posts;
DROP TABLE IF EXISTS token;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS vote;

-- ----------------------------------------------------

-- Mostrando todos os registros nas tabelas
SELECT * FROM `projectreddit`.comment;
SELECT * FROM `projectreddit`.post; 
SELECT * FROM `projectreddit`.refresh_token;
SELECT * FROM `projectreddit`.subreddit;
SELECT * FROM `projectreddit`.subreddit_posts;
SELECT * FROM `projectreddit`.token;
SELECT * FROM `projectreddit`.user;
SELECT * FROM `projectreddit`.vote;

-- Deletar as tabelas criadas automaticamente pela aplicação
DROP TABLE IF EXISTS `projectreddit`.comment;
DROP TABLE IF EXISTS `projectreddit`.post; 
DROP TABLE IF EXISTS `projectreddit`.refresh_token;
DROP TABLE IF EXISTS `projectreddit`.subreddit;
DROP TABLE IF EXISTS `projectreddit`.subreddit_posts;
DROP TABLE IF EXISTS `projectreddit`.token;
DROP TABLE IF EXISTS `projectreddit`.user;
DROP TABLE IF EXISTS `projectreddit`.vote;

-- Deletando os registros na tabelas
DELETE FROM `projectreddit`.comment;
DELETE FROM `projectreddit`.post; 
DELETE FROM `projectreddit`.refresh_token;
DELETE FROM `projectreddit`.subreddit;
DELETE FROM `projectreddit`.subreddit_posts;
DELETE FROM `projectreddit`.token;
DELETE FROM `projectreddit`.user;
DELETE FROM `projectreddit`.vote;