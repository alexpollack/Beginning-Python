#lang scheme

; unzip: a function that 'unzips' a set of tuples
(define (unzip xys)
  (match xys
    ['() (cons '() '())]
    [(cons hd tl)
     (let* ((res (unzip tl)))
       (cons (cons (car hd) (car res)) (cons (cdr hd) (cdr res))))]))


; flatten: flattens a list of tuples
(define flatten
  (lambda (xs)
    (letrec ([flattentail
              (lambda (xs lis)
                (cond
                  ((null? xs) lis)
                  ((not (list? xs))  (list xs))
                  ((list? (car xs))
                     (flattentail (cdr xs) (append (flattentail (car xs) '()) lis)))
                     (else (flattentail(cdr xs) (cons (car xs) lis)))))])
      (reverse (flattentail xs '())))))

; unzip-alt: an alternate form of unzip using foldr
(define (unzip-alt xys)
  (match xys
    ['() (cons '() '())]
    [(cons hd tl)
     (let* ((res (unzip tl)))
       (foldr cons '() (cons (cons (car hd) (car res)) (cons (cdr hd) (cdr res)))))]))


; foldr-alt: an alternate way to create the fold right tool using fold left (foldl)
(define (foldr-alt op z xs)
    (match xs
      [(cons hd tl) (foldl op z (foldl cons '() xs))]
      ['() z]))


; in-relation: compares the relation of two inputs and returns true or false based on that 
(define in-relation
  (lambda (p xs)
  (letrec ((reltail
            (lambda (p xs)
              (cond ((null? xs) #t)
                    ((eq? (length xs) 1) #t)
                    ((p (car xs) (cadr xs)) (reltail p (cdr xs)))
                    (else #f)))))
    (reltail p xs))))


; Unit tests

(require rackunit)

; unzip
(check-equal?
 (unzip '((1 . a) (2 . b) (3 . c)))
 '((1 2 3) . (a b c)))
(check-equal?
 (unzip '((1 . 2)))
 '((1) . (2)))
(check-equal?
 (unzip '())
 '(() . ()))

; flatten
(check-equal?
 (flatten 1)
 '(1))
(check-equal?
 (flatten (cons 1 2))
 '((1 . 2)))
(check-equal?
 (flatten `(1 2 3))
 '(1 2 3))
(check-equal?
 (flatten `(1 (3 4) 5))
 '(1 3 4 5))
(check-equal?
 (flatten '(1 (2 3 (4 5) (6 7 (8)) 9) 10))
 '(1 2 3 4 5 6 7 8 9 10))

; unzip-alt
(check-equal?
 (unzip-alt '((1 . a) (2 . b) (3 . c)))
 '((1 2 3) . (a b c)))
(check-equal?
 (unzip-alt '((1 . 2)))
 '((1) . (2)))
(check-equal?
 (unzip-alt '())
 '(() . ()))

; foldr-alt
(check-equal?
 (foldr-alt + 0 '(1 2 3))
 6)
(check-equal?
 (foldr-alt + 0 '())
 0)
(check-equal?
 (foldr-alt cons '() '(1 2 3))
 '(1 2 3))
(check-equal?
 (foldr-alt cons '() '())
 '())
(check-equal?
 (foldr-alt (lambda (hd res) (cons (+ hd 1) res)) '() '(1 2 3))
 '(2 3 4))

; in-relation
(check-equal?
 (in-relation < '(1 2 3 5 6))
 #t)
(check-equal?
 (in-relation < '(1))
 #t)
(check-equal?
 (in-relation < '())
 #t)
(check-equal?
 (in-relation < '(1 3 2))
 #f)
(check-equal?
 (in-relation eq? '(1 1 1))
 #t)
(check-equal?
 (in-relation eq? '(1 1 2))
 #f)
(check-equal?
 (in-relation (lambda (x y) (eq? y (+ x 1))) '(1 2 3))
 #t)
(check-equal?
 (in-relation (lambda (x y) (eq? y (+ x 1))) '(1 2 4)))



        
        
  

