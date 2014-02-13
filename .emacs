;; .emacs

;;; uncomment this line to disable loading of "default.el" at startup
;; (setq inhibit-default-init t)

;; turn on font-lock mode
(when (fboundp 'global-font-lock-mode)
  (global-font-lock-mode t))

;; enable visual feedback on selections
(setq transient-mark-mode t)

;; default to better frame titles
(setq frame-title-format
      (concat  "%b - emacs@" system-name))


;; tab three spaces, not 4
(setq c-basic-offset 3)

;; tab inserts spaces, not tabs
(setq-default indent-tabs-mode nil)

;; how about not-ugly-color
(global-font-lock-mode t)


;; Change the indention style so we don't get too angry with Emacs
(defconst my-c++-style
 '((c-tab-always-indent        . t)
   (c-comment-only-line-offset . 0)
   (c-hanging-braces-alist     . ((substatement-open after)
                                  (brace-list-open)))
   (c-hanging-colons-alist     . ((member-init-intro before)
                                  (inher-intro)
                                  (case-label after)
                                  (label after)
                                  (access-label after)))
   (c-cleanup-list             . (scope-operator
                                  ;empty-defun-braces
                                  defun-close-semi))
   (c-offsets-alist            . ((arglist-close . c-lineup-arglist)
                                  (func-decl-cont . 0)
                                  (inline-open       . 0)
                                  (substatement-open . 0)
                                  (case-label        . +)
                                  (block-open        . 0)
                                  (knr-argdecl-intro . -)))
   (c-echo-syntactic-information-p . t)
   )
 )

;; Customizations for all of c-mode, c++-mode, and objc-mode
(defun my-c-mode-common-hook ()
 ;; add my personal style and set it for the current buffer
 (c-add-style "PERSONAL" my-c++-style t)
 ;; offset customizations not in my-c-style
 (c-set-offset 'member-init-intro '++)
 ;; other customizations

 ;; we don't like auto-newline and hungry-delete
 (c-toggle-auto-hungry-state -1)
 ;; keybindings for all supported languages.  We can put these in
 ;; c-mode-base-map because c-mode-map, c++-mode-map, objc-mode-map,
 ;; java-mode-map, and idl-mode-map inherit from it.
 (define-key c-mode-base-map "\C-m" 'newline-and-indent)
 ;; required so tab offset is really three
 (setq c-tab-always-indent 42)
 (setq c-basic-offset 3)
 )

(add-hook 'c-mode-common-hook 'my-c-mode-common-hook)

(when window-system
  ;; enable wheelmouse support by default
  (mwheel-install)
  ;; use extended compound-text coding for X clipboard
  (set-selection-coding-system 'compound-text-with-extensions))

;; Enable wheelmouse support by default
(require 'mwheel)

(global-set-key "\C-z" '(lambda nil (interactive) (scroll-up 0)))


(custom-set-variables
  ;; custom-set-variables was added by Custom.
  ;; If you edit it by hand, you could mess it up, so be careful.
  ;; Your init file should contain only one such instance.
  ;; If there is more than one, they won't work right.
 '(inhibit-startup-screen t))
(custom-set-faces
  ;; custom-set-faces was added by Custom.
  ;; If you edit it by hand, you could mess it up, so be careful.
  ;; Your init file should contain only one such instance.
  ;; If there is more than one, they won't work right.
 )
