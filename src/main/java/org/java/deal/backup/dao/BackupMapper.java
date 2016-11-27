package org.java.deal.backup.dao;

import java.util.List;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.deal.backup.entity.Backup;

@MyBatisRepository
public interface BackupMapper extends BaseDao<Backup> {
}