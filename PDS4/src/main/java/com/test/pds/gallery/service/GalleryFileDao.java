package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 데이터베이스 pds내 테이블 gallery_file에 접근하는 Dao
 */
@Repository
public class GalleryFileDao {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryFileDao.class);
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.test.pds.gallery.service.GalleryFileMapper.";
	
	/**
	 * 선택된 gallery에 수정하고자하는 이미지파일을 수정하는 메서드
	 * @param galleryFile
	 * @return 수정된 행의 수
	 */
	public int updateGalleryFile(GalleryFile galleryFile) {
		return sqlSessionTemplate.update(NAMESPACE+"updateGalleryFile", galleryFile);
	}
	
	/**
	 * 삭제하고자하는 이미지파일리스트를 출력하는 메서드
	 * @param galleryId
	 * @return 이미지파일 리스트
	 */
	public List<GalleryFile> selectGalleryFileList(int galleryId) {
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryFileList", galleryId);
	}
	
	/**
	 * 선택한 gallery에 등록된 이미지파일을 삭제하는 메서드
	 * @param galleryId
	 * @return 삭제된 행의 수
	 */
	public int deleteGalleryFile(int galleryId) {
		logger.debug("GalleryFileDao.deleteGalleryFile 메서드 실행");
		return sqlSessionTemplate.delete(NAMESPACE+"deleteGalleryFile", galleryId);
	}
	
	/*public List<GalleryFile> selectGalleryFileList(int galleryId) {
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryFileList", galleryId);
	}*/
	
	/**
	 * galleryFile를 등록하는 메서드
	 * @param gallery
	 * @return 등록된 행의 수
	 */
	public int insertGalleryFile(GalleryFile galleryFile) {
		logger.debug("GalleryFileDao.insertGalleryFile 메서드 실행");
		return sqlSessionTemplate.insert("insertGalleryFile", galleryFile);
	}
}
