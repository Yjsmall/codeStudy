section .bsss
strHello db "Hello,world!",0Ah
STRLEN equ $ -strHello

section .file1text
extern print

global _start

_start:
	push STRLEN
	push strHello
	call print

	mov ebx,0
	mov eax,1
	int 0x80
