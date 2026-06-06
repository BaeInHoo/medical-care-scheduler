import styles from "./page.module.css";

export default function Home() {
  return (
    <div className={styles.page}>
      <main className={styles.main}>
        <p className={styles.eyebrow}>Medical Care Scheduler</p>
        <h1>병원 예약과 약 복용 일정을 한곳에서 관리합니다.</h1>
        <p className={styles.description}>
          현재는 서비스 개발을 위한 기본 프로젝트 구조가 준비된 단계입니다.
          예약, 알림, 로그인 기능은 다음 단계에서 구현합니다.
        </p>
        <div className={styles.status}>프로젝트 기본 구조 준비 완료</div>
      </main>
    </div>
  );
}
