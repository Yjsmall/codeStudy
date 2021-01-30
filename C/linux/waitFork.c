#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
int main() {
    pid_t pc,pr;
    pc = fork();
    if (pc < 0) {
        printf("create process failed\n");
    } else if (pc == 0) {
        printf("This is child process with pid of %d\n",getpid());
    } else {
        printf("I catched a child process with pid of %d\n",pr);
    }

    return 0;
}