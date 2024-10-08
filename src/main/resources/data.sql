---- REGION_FIRST 데이터 초기화
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('서울특별시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('부산광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('대구광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('인천광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('광주광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('대전광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('울산광역시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('세종특별자치시');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('경기도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('충청북도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('충청남도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('전라북도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('전라남도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('경상북도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('경상남도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('제주특별자치도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('이어도');
--INSERT INTO REGION_FIRST (RF_NAME) VALUES ('강원특별자치도');
--
--
---- REGION 데이터 초기화
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 60, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '종로구', RF.RF_ID, 60, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 60, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '용산구', RF.RF_ID, 60, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성동구', RF.RF_ID, 61, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '광진구', RF.RF_ID, 62, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동대문구', RF.RF_ID, 61, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중랑구', RF.RF_ID, 62, 128 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성북구', RF.RF_ID, 61, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강북구', RF.RF_ID, 61, 128 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '도봉구', RF.RF_ID, 61, 129 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '노원구', RF.RF_ID, 61, 129 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '은평구', RF.RF_ID, 59, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서대문구', RF.RF_ID, 59, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '마포구', RF.RF_ID, 59, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양천구', RF.RF_ID, 58, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강서구', RF.RF_ID, 58, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '구로구', RF.RF_ID, 58, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '금천구', RF.RF_ID, 59, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영등포구', RF.RF_ID, 58, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동작구', RF.RF_ID, 59, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '관악구', RF.RF_ID, 59, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서초구', RF.RF_ID, 61, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강남구', RF.RF_ID, 61, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '송파구', RF.RF_ID, 62, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강동구', RF.RF_ID, 62, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '서울특별시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 98, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 97, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서구', RF.RF_ID, 97, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 98, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영도구', RF.RF_ID, 98, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부산진구', RF.RF_ID, 97, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동래구', RF.RF_ID, 98, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남구', RF.RF_ID, 98, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '북구', RF.RF_ID, 96, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '해운대구', RF.RF_ID, 99, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '사하구', RF.RF_ID, 96, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '금정구', RF.RF_ID, 98, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강서구', RF.RF_ID, 96, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '연제구', RF.RF_ID, 98, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수영구', RF.RF_ID, 99, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '사상구', RF.RF_ID, 96, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '기장군', RF.RF_ID, 100, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '부산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 89, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 89, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 90, 91 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서구', RF.RF_ID, 88, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남구', RF.RF_ID, 89, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '북구', RF.RF_ID, 89, 91 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수성구', RF.RF_ID, 89, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '달서구', RF.RF_ID, 88, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '달성군', RF.RF_ID, 86, 88 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '군위군', RF.RF_ID, 88, 99 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대구광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 55, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 54, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 54, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '미추홀구', RF.RF_ID, 54, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '연수구', RF.RF_ID, 55, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남동구', RF.RF_ID, 56, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부평구', RF.RF_ID, 55, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '계양구', RF.RF_ID, 56, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서구', RF.RF_ID, 55, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강화군', RF.RF_ID, 51, 130 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '옹진군', RF.RF_ID, 54, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '인천광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 58, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 60, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서구', RF.RF_ID, 59, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남구', RF.RF_ID, 59, 73 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '북구', RF.RF_ID, 59, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '광산구', RF.RF_ID, 57, 74 FROM REGION_FIRST RF WHERE RF.RF_NAME = '광주광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 67, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 68, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 68, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서구', RF.RF_ID, 67, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '유성구', RF.RF_ID, 67, 101 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '대덕구', RF.RF_ID, 68, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '대전광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 102, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '중구', RF.RF_ID, 102, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남구', RF.RF_ID, 102, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동구', RF.RF_ID, 104, 83 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '북구', RF.RF_ID, 103, 85 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '울주군', RF.RF_ID, 101, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '울산광역시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 66, 103 FROM REGION_FIRST RF WHERE RF.RF_NAME = '세종특별자치시';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 60, 120 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수원시장안구', RF.RF_ID, 60, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수원시권선구', RF.RF_ID, 60, 120 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수원시팔달구', RF.RF_ID, 61, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '수원시영통구', RF.RF_ID, 61, 120 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성남시수정구', RF.RF_ID, 63, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성남시중원구', RF.RF_ID, 63, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성남시분당구', RF.RF_ID, 62, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '의정부시', RF.RF_ID, 61, 130 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안양시만안구', RF.RF_ID, 59, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안양시동안구', RF.RF_ID, 59, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부천시원미구', RF.RF_ID, 57, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부천시소사구', RF.RF_ID, 57, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부천시오정구', RF.RF_ID, 57, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '광명시', RF.RF_ID, 58, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '평택시', RF.RF_ID, 62, 114 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동두천시', RF.RF_ID, 61, 134 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안산시상록구', RF.RF_ID, 58, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안산시단원구', RF.RF_ID, 57, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고양시덕양구', RF.RF_ID, 57, 128 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고양시일산동구', RF.RF_ID, 56, 129 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고양시일산서구', RF.RF_ID, 56, 129 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '과천시', RF.RF_ID, 60, 124 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '구리시', RF.RF_ID, 62, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남양주시', RF.RF_ID, 64, 128 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '오산시', RF.RF_ID, 62, 118 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '시흥시', RF.RF_ID, 57, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '군포시', RF.RF_ID, 59, 122 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '의왕시', RF.RF_ID, 60, 122 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '하남시', RF.RF_ID, 64, 126 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '용인시처인구', RF.RF_ID, 64, 119 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '용인시기흥구', RF.RF_ID, 62, 120 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '용인시수지구', RF.RF_ID, 62, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '파주시', RF.RF_ID, 56, 131 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '이천시', RF.RF_ID, 68, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안성시', RF.RF_ID, 65, 115 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '김포시', RF.RF_ID, 55, 128 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '화성시', RF.RF_ID, 57, 119 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '광주시', RF.RF_ID, 65, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양주시', RF.RF_ID, 61, 131 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '포천시', RF.RF_ID, 64, 134 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '여주시', RF.RF_ID, 71, 121 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '연천군', RF.RF_ID, 61, 138 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '가평군', RF.RF_ID, 69, 133 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양평군', RF.RF_ID, 69, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경기도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 69, 107 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청주시상당구', RF.RF_ID, 69, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청주시서원구', RF.RF_ID, 69, 107 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청주시흥덕구', RF.RF_ID, 67, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청주시청원구', RF.RF_ID, 69, 107 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '충주시', RF.RF_ID, 76, 114 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '제천시', RF.RF_ID, 81, 118 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '보은군', RF.RF_ID, 73, 103 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '옥천군', RF.RF_ID, 71, 99 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영동군', RF.RF_ID, 74, 97 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '증평군', RF.RF_ID, 71, 110 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '진천군', RF.RF_ID, 68, 111 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '괴산군', RF.RF_ID, 74, 111 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '음성군', RF.RF_ID, 72, 113 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '단양군', RF.RF_ID, 84, 115 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 68, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '천안시동남구', RF.RF_ID, 63, 110 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '천안시서북구', RF.RF_ID, 63, 112 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '공주시', RF.RF_ID, 63, 102 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '보령시', RF.RF_ID, 54, 100 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '아산시', RF.RF_ID, 60, 110 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서산시', RF.RF_ID, 51, 110 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '논산시', RF.RF_ID, 62, 97 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '계룡시', RF.RF_ID, 65, 99 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '당진시', RF.RF_ID, 54, 112 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '금산군', RF.RF_ID, 69, 95 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부여군', RF.RF_ID, 59, 99 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서천군', RF.RF_ID, 55, 94 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청양군', RF.RF_ID, 57, 103 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '홍성군', RF.RF_ID, 55, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '예산군', RF.RF_ID, 58, 107 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '태안군', RF.RF_ID, 48, 109 FROM REGION_FIRST RF WHERE RF.RF_NAME = '충청남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 63, 89 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전주시완산구', RF.RF_ID, 63, 89 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전주시덕진구', RF.RF_ID, 63, 89 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '군산시', RF.RF_ID, 56, 92 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '익산시', RF.RF_ID, 60, 91 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '정읍시', RF.RF_ID, 58, 83 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남원시', RF.RF_ID, 68, 80 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '김제시', RF.RF_ID, 59, 88 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '완주군', RF.RF_ID, 63, 89 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '진안군', RF.RF_ID, 68, 88 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '무주군', RF.RF_ID, 72, 93 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '장수군', RF.RF_ID, 70, 85 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '임실군', RF.RF_ID, 66, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '순창군', RF.RF_ID, 63, 79 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고창군', RF.RF_ID, 56, 80 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '부안군', RF.RF_ID, 56, 87 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 51, 67 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '목포시', RF.RF_ID, 50, 67 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '여수시', RF.RF_ID, 73, 66 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '순천시', RF.RF_ID, 70, 70 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '나주시', RF.RF_ID, 56, 71 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '광양시', RF.RF_ID, 73, 70 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '담양군', RF.RF_ID, 61, 78 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '곡성군', RF.RF_ID, 66, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '구례군', RF.RF_ID, 69, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고흥군', RF.RF_ID, 66, 62 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '보성군', RF.RF_ID, 62, 66 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '화순군', RF.RF_ID, 61, 72 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '장흥군', RF.RF_ID, 59, 64 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강진군', RF.RF_ID, 57, 63 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '해남군', RF.RF_ID, 54, 61 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영암군', RF.RF_ID, 56, 66 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '무안군', RF.RF_ID, 52, 71 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '함평군', RF.RF_ID, 52, 72 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영광군', RF.RF_ID, 52, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '장성군', RF.RF_ID, 57, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '완도군', RF.RF_ID, 57, 56 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '진도군', RF.RF_ID, 48, 59 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '신안군', RF.RF_ID, 50, 66 FROM REGION_FIRST RF WHERE RF.RF_NAME = '전라남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 87, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '포항시남구', RF.RF_ID, 102, 94 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '포항시북구', RF.RF_ID, 102, 95 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '경주시', RF.RF_ID, 100, 91 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '김천시', RF.RF_ID, 80, 96 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '안동시', RF.RF_ID, 91, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '구미시', RF.RF_ID, 84, 96 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영주시', RF.RF_ID, 89, 111 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영천시', RF.RF_ID, 95, 93 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '상주시', RF.RF_ID, 81, 102 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '문경시', RF.RF_ID, 81, 106 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '경산시', RF.RF_ID, 91, 90 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '의성군', RF.RF_ID, 90, 101 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청송군', RF.RF_ID, 96, 103 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영양군', RF.RF_ID, 97, 108 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영덕군', RF.RF_ID, 102, 103 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '청도군', RF.RF_ID, 91, 86 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고령군', RF.RF_ID, 83, 87 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '성주군', RF.RF_ID, 83, 91 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '칠곡군', RF.RF_ID, 85, 93 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '예천군', RF.RF_ID, 86, 107 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '봉화군', RF.RF_ID, 90, 113 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '울진군', RF.RF_ID, 102, 115 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '울릉군', RF.RF_ID, 127, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상북도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 91, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창원시의창구', RF.RF_ID, 90, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창원시성산구', RF.RF_ID, 91, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창원시마산합포구', RF.RF_ID, 89, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창원시마산회원구', RF.RF_ID, 89, 76 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창원시진해구', RF.RF_ID, 91, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '진주시', RF.RF_ID, 81, 75 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '통영시', RF.RF_ID, 87, 68 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '사천시', RF.RF_ID, 80, 71 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '김해시', RF.RF_ID, 95, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '밀양시', RF.RF_ID, 92, 83 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '거제시', RF.RF_ID, 90, 69 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양산시', RF.RF_ID, 97, 79 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '의령군', RF.RF_ID, 83, 78 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '함안군', RF.RF_ID, 86, 77 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '창녕군', RF.RF_ID, 87, 83 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고성군', RF.RF_ID, 85, 71 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '남해군', RF.RF_ID, 77, 68 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '하동군', RF.RF_ID, 74, 73 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '산청군', RF.RF_ID, 76, 80 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '함양군', RF.RF_ID, 74, 82 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '거창군', RF.RF_ID, 77, 86 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '합천군', RF.RF_ID, 81, 84 FROM REGION_FIRST RF WHERE RF.RF_NAME = '경상남도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 52, 38 FROM REGION_FIRST RF WHERE RF.RF_NAME = '제주특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '제주시', RF.RF_ID, 53, 38 FROM REGION_FIRST RF WHERE RF.RF_NAME = '제주특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '서귀포시', RF.RF_ID, 52, 33 FROM REGION_FIRST RF WHERE RF.RF_NAME = '제주특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 28, 8 FROM REGION_FIRST RF WHERE RF.RF_NAME = '이어도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '전체', RF.RF_ID, 73, 134 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '춘천시', RF.RF_ID, 73, 134 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '원주시', RF.RF_ID, 76, 122 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '강릉시', RF.RF_ID, 92, 131 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '동해시', RF.RF_ID, 97, 127 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '태백시', RF.RF_ID, 95, 119 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '속초시', RF.RF_ID, 87, 141 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '삼척시', RF.RF_ID, 98, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '홍천군', RF.RF_ID, 75, 130 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '횡성군', RF.RF_ID, 77, 125 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '영월군', RF.RF_ID, 86, 119 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '평창군', RF.RF_ID, 84, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '정선군', RF.RF_ID, 89, 123 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '철원군', RF.RF_ID, 65, 139 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '화천군', RF.RF_ID, 72, 139 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양구군', RF.RF_ID, 77, 139 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '인제군', RF.RF_ID, 80, 138 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '고성군', RF.RF_ID, 85, 145 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--INSERT INTO REGION (REGION_NAME, RF_ID, NX, NY) SELECT '양양군', RF.RF_ID, 88, 138 FROM REGION_FIRST RF WHERE RF.RF_NAME = '강원특별자치도';
--
