/**
 * 增加字典的根节点  字典列表
 */

INSERT INTO `dic_system_dictionary` VALUES('1','字典列表',NULL,'','字典列表','0','0','dictionaryList','varchar(6)',NULL,NULL);

/**
 * [upDictionaryOptionId description]
 * 更新二级字典数据的上级节点
 * @type {String}
 */
UPDATE `dic_system_dictionary` SET upDictionaryOptionId='1' WHERE dictionaryOptionId='100';
UPDATE `dic_system_dictionary` SET upDictionaryOptionId='1' WHERE dictionaryOptionId='200';
UPDATE `dic_system_dictionary` SET upDictionaryOptionId='1' WHERE dictionaryOptionId='300';
UPDATE `dic_system_dictionary` SET upDictionaryOptionId='1' WHERE dictionaryOptionId='400';
UPDATE `dic_system_dictionary` SET upDictionaryOptionId='1' WHERE dictionaryOptionId='500';


/**
 * 字典级联删除和更新
 */
ALTER TABLE dic_system_dictionary ADD (CONSTRAINT FK_DIC FOREIGN KEY (upDictionaryOptionId) 
REFERENCES dic_system_dictionary(dictionaryOptionId) ON DELETE CASCADE ON UPDATE CASCADE);