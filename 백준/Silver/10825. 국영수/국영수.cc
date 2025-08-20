#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream> // std::ostringstream 사용

using namespace std;

struct Student {
    string name;
    int kor;
    int eng;
    int math;
};

// 비교 함수
bool compare(const Student &student1, const Student &student2) {
    if (student1.kor != student2.kor) return student1.kor > student2.kor; // 국어 점수 내림차순
    if (student1.eng != student2.eng) return student1.eng < student2.eng; // 영어 점수 오름차순
    if (student1.math != student2.math) return student1.math > student2.math; // 수학 점수 내림차순
    return student1.name < student2.name; // 이름 사전 순 증가
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int number;
    cin >> number;

    vector<Student> students(number);

    for (int i = 0; i < number; i++) {
        cin >> students[i].name >> students[i].kor >> students[i].eng >> students[i].math;
    }

    // 정렬
    sort(students.begin(), students.end(), compare);

    // 결과를 저장할 문자열 버퍼
    ostringstream output;

    for (const auto& student : students) {
        output << student.name << '\n';
    }

    // 한 번에 출력
    cout << output.str();

    return 0;
}
