# Medical Care Scheduler

병원 예약 일정과 약 복용 시간을 관리하기 위한 웹 서비스입니다.

현재 단계에서는 프론트엔드와 백엔드의 독립 실행이 가능한 기본 프로젝트 구조만 제공합니다. 로그인, JWT 인증, 병원 예약, 약 복용 알림, CRUD 기능은 아직 구현하지 않았습니다.

## 기술 스택

### Frontend

- Next.js 16
- React 19
- TypeScript
- App Router
- ESLint

### Backend

- Spring Boot 4
- Java 17
- Gradle
- Spring Web MVC

### 예정 기술

- MariaDB
- REST API
- JWT 인증

## 폴더 구조

```text
medical-care-scheduler/
├─ frontend/
│  ├─ public/
│  ├─ src/
│  │  └─ app/
│  ├─ package.json
│  └─ tsconfig.json
├─ backend/
│  ├─ gradle/
│  ├─ src/
│  │  ├─ main/
│  │  │  ├─ java/com/medicalcare/scheduler/
│  │  │  └─ resources/
│  │  └─ test/
│  ├─ build.gradle
│  ├─ gradlew
│  └─ gradlew.bat
└─ README.md
```

## 프론트엔드 실행 방법

Node.js 20.9 이상이 필요합니다.

```bash
cd frontend
npm install
npm run dev
```

브라우저에서 `http://localhost:3000`으로 접속합니다.

프로덕션 빌드 확인:

```bash
npm run build
npm run start
```

## 백엔드 실행 방법

Java 17 이상이 필요합니다. Gradle Wrapper가 포함되어 있어 별도 Gradle 설치는 필요하지 않습니다.

Windows:

```powershell
cd backend
.\gradlew.bat bootRun
```

macOS/Linux:

```bash
cd backend
./gradlew bootRun
```

백엔드는 `http://localhost:8080`에서 실행됩니다. 현재는 별도 REST API 엔드포인트를 제공하지 않습니다.

## 앞으로 구현할 기능

- 회원가입 및 로그인
- JWT 기반 인증 및 권한 처리
- 사용자 프로필 관리
- 병원 검색 및 예약 일정 CRUD
- 예약 전 알림
- 복용 약 및 복용 시간 CRUD
- 약 복용 시간 알림
- 복용 완료 여부 기록
- MariaDB 연동 및 데이터 영속화
- 프론트엔드와 REST API 연동
- 입력값 검증 및 공통 예외 처리
- 테스트 및 배포 환경 구성
