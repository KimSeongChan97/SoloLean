// 1. 액션 생성
const TIGER = 'name/TIGER';
const DOG = 'name/DOG';
const CAT = 'name/CAT';
const CHICK = 'name/CHICK';

// 2. 액션 보내기 ( action 객체 )
export const tiger = () => ({ type: TIGER });
export const dog = () => ({ type: DOG });
export const cat = () => ({ type: CAT });
export const chick = () => ({ type: CHICK });

// 3. 초기값
const initialState = { name: '돼지', crying: '꿀꿀' };

// 4. 리듀서 만들기
const animal = (state = initialState, action) => {
     switch (action.type) {
          case TIGER: return { ...state, name: '호랑이', crying: '어흥' };
          case DOG: return { ...state, name: '강아지', crying: '멍멍' };
          case CAT: return { ...state, name: '고양이', crying: '야옹' };
          case CHICK: return { ...state, name: '병아리', crying: '삐약' };
          default: return state;
      }
};

export default animal;