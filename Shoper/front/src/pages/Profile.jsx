import React from 'react';
import useUserStore from '../store/userStore'; // useUserStore 경로를 정확히 지정해주세요.
// 예: src/stores/useUserStore.js 또는 src/zustand/useUserStore.js

function Profile() {
  // useUserStore 훅을 사용하여 user 상태와 isAuthenticated 상태를 가져옵니다.
  // 이 방법은 스토어에서 필요한 부분만 선택적으로 가져오므로 불필요한 리렌더링을 줄일 수 있습니다.
  const user = useUserStore((state) => state.user);
  const isAuthenticated = useUserStore((state) => state.isAuthenticated);

  // 사용자가 로그인되어 있지 않다면 (isAuthenticated가 false이거나 user가 null인 경우)
  if (!isAuthenticated || !user) {
    return <p>로그인 정보가 없습니다.</p>;
  }

  // 로그인된 사용자 정보가 있다면 프로필을 표시합니다.
  // 여기서는 로그인 시 저장하는 user 데이터 (email, username, role)만 사용합니다.
  // 추가 정보(id, createdAt, updatedAt)가 필요하다면 login 액션에서 해당 정보들도 저장해야 합니다.
  return (
    <div>
      <h2>프로필 정보</h2>
      <p>
        <strong>이메일:</strong> {user.email}
      </p>
      <p>
        <strong>사용자 이름:</strong> {user.username}
      </p>
      <p>
        <strong>역할:</strong> {user.role}
      </p>

      {/* 주의: 현재 useUserStore의 login 액션은 id, createdAt, updatedAt을 user 객체에 저장하지 않습니다.
        만약 이 정보들도 프로필에 표시하고 싶다면, login 액션을 다음과 같이 수정해야 합니다:

        login: (userData) => {
          set({
            user: {
              id: userData.id, // ID 추가
              email: userData.email,
              username: userData.username,
              role: userData.role,
              createdAt: userData.createdAt, // createdAt 추가
              updatedAt: userData.updatedAt, // updatedAt 추가
            },
            isAuthenticated: true,
          });
        },
      */}
      {/* <p><strong>ID:</strong> {user.id}</p> */}
      {/* <p><strong>가입일:</strong> {new Date(user.createdAt).toLocaleDateString('ko-KR')}</p> */}
    </div>
  );
}

export default Profile;
