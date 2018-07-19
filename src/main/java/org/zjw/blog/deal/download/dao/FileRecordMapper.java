package org.zjw.blog.deal.download.dao;

import org.zjw.blog.base.common.dao.MyBatisRepository;
import org.zjw.blog.deal.download.entity.FileRecord;

import java.util.List;
import java.util.Map;
@MyBatisRepository
public interface FileRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileRecord record);

    int insertSelective(FileRecord record);

    FileRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileRecord record);

    int updateByPrimaryKey(FileRecord record);

    /**
     *根据查询条件获得文件记录
     * @return
     * @param paramMap
     */
    List<FileRecord> getFileRecordList(Map<String, Object> paramMap);
}