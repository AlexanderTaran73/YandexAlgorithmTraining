#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    int n;
    scanf("%d", &n);
    int stat = -1; // Используем -1 для обозначения начального значения

    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);

        if (stat == -1) {
            stat = abs(num) % 2 == 1 ? 1 : 0;
        } else if (stat == 0) {
            if (abs(num) % 2 == 1) {
                printf("+");
                stat = 1;
            } else {
                printf("x");
            }
        } else {
            if (abs(num) % 2 == 1) {
                printf("x");
                stat = 1;
            } else {
                printf("+");
            }
        }
    }

    return 0;
}